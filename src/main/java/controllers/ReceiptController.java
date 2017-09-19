package controllers;

import api.CreateReceiptRequest;
import api.ReceiptResponse;
import dao.ReceiptDao;
import dao.TagDAO;
import generated.tables.records.ReceiptsRecord;
import generated.tables.records.ReceipttagRecord;
import jdk.nashorn.internal.parser.JSONParser;
import org.jooq.DSLContext;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


import static java.util.stream.Collectors.toList;

@Path("/receipts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReceiptController {
    final ReceiptDao receipts;
    final TagDAO tags;

    public ReceiptController(ReceiptDao receipts, TagDAO tags) {
        this.receipts = receipts;
        this.tags=tags;
    }

    @POST
    public int createReceipt(@Valid @NotNull CreateReceiptRequest receipt) {
        return receipts.insert(receipt.merchant, receipt.amount);
    }

    @GET
    public List<ReceiptResponse> getReceipts() {
        List<ReceiptsRecord> receiptRecords = receipts.getAllReceipts();
        List<ReceiptResponse> receiptResponse=new ArrayList<>();
        for(int i=0; i< receiptRecords.size(); i++){
            receiptResponse.add(new ReceiptResponse(receiptRecords.get(i), tags.getTagsByID(receiptRecords.get(i).getId()).stream().map(ReceipttagRecord::getReceiptTag).collect(toList())));
        }
        return receiptResponse;
    }


}
