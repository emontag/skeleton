package controllers;
import api.ReceiptResponse;
import dao.ReceiptDao;
import dao.TagDAO;
import generated.tables.records.ReceiptsRecord;
import generated.tables.records.ReceipttagRecord;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Path("/tags")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TagController {
    final TagDAO tags;
    final ReceiptDao receipts;

    public TagController(TagDAO tags, ReceiptDao receipts) {
        this.tags = tags;
        this.receipts=receipts;
    }



    @PUT
    @Path("/{tag}")
    public void toggleTag(@PathParam("tag") String tagName, @Valid @NotNull Integer ID){
        tags.insertTag(tagName, ID);



    }
    @GET
    @Path("/{tag}")
    public List<ReceiptResponse> getTaggedReceipts(@PathParam("tag") String tag){

        List<ReceiptsRecord> receiptRecords = tags.getTag(tag);
        List<ReceiptResponse> receiptResponse=new ArrayList<>();
        for(int i=0; i< receiptRecords.size(); i++){
            receiptResponse.add(new ReceiptResponse(receiptRecords.get(i), tags.getTagsByID(receiptRecords.get(i).getId()).stream().map(ReceipttagRecord::getReceiptTag).collect(toList())));
        }
        return receiptResponse;
    }




}
