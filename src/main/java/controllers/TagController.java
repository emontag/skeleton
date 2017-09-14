package controllers;
import api.ReceiptResponse;
import dao.ReceiptDao;
import dao.TagDAO;
import generated.tables.Receipttag;
import generated.tables.records.ReceiptsRecord;
import generated.tables.records.ReceipttagRecord;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Path("/tags")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TagController {
    final TagDAO receipts;

    public TagController(TagDAO receipts) {
        this.receipts = receipts;
    }



    @PUT
    @Path("/{tag}")
    public void toggleTag(@PathParam("tag") String tagName, @Valid @NotNull Integer ID){
        receipts.insertTag(tagName, ID);



    }
    @GET
    @Path("/{tag}")
    public List<ReceiptResponse> getTaggedReceipts(@PathParam("tag") String tag){

        List<ReceiptsRecord> receiptRecords = receipts.getTag(tag);
        return receiptRecords.stream().map(ReceiptResponse::new).collect(toList());
    }


}
