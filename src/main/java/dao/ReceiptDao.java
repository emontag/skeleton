package dao;

import generated.tables.Receipttag;
import generated.tables.records.ReceiptsRecord;
import generated.tables.records.ReceipttagRecord;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.impl.DSL;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.*;

import static com.google.common.base.Preconditions.checkState;
import static generated.Tables.RECEIPTS;
//import static generated.Tables.RECEIPTTAG;

public class ReceiptDao {
    DSLContext dsl;

    public ReceiptDao(Configuration jooqConfig) {
        this.dsl = DSL.using(jooqConfig);
    }

    public int insert(String merchantName, BigDecimal amount) {
        ReceiptsRecord receiptsRecord = dsl
                .insertInto(RECEIPTS, RECEIPTS.MERCHANT, RECEIPTS.AMOUNT)
                .values(merchantName, amount)
                .returning(RECEIPTS.ID)
                .fetchOne();

        checkState(receiptsRecord != null && receiptsRecord.getId() != null, "Insert failed");

        return receiptsRecord.getId();
    }

    public List<ReceiptsRecord> getAllReceipts() {
        return dsl.selectFrom(RECEIPTS).fetch();
    }

    /*public void insertTag(String tag, Integer ID) {
        Record2<Integer, String> rec = dsl.select(RECEIPTTAG.ID, RECEIPTTAG.RECEIPT_TAG).from(RECEIPTTAG).fetchOne();
        if (rec != null) {
            dsl.deleteFrom(RECEIPTTAG).where(RECEIPTTAG.ID.contains(ID));
        } else {
            dsl.insertInto(RECEIPTTAG, RECEIPTTAG.ID, RECEIPTTAG.RECEIPT_TAG)
                    .values(ID, tag)
                    .execute();
        }


        //checkState(receiptsRecord != null && receiptsRecord.getId() != null, "Insert failed");
    }

    public List<ReceiptsRecord> getTag() {
        /*List<ReceiptsRecord> list=dsl.selectFrom(RECEIPTS).fetch();
        List<ReceiptsRecord> copy=list.subList(0, list.size());
        List <ReceipttagRecord> rlist=dsl.selectFrom(RECEIPTTAG).fetch();
        List<Integer> array=new ArrayList<>();
        String s="";
        for(int i=0; i< rlist.size(); i++){
            int id=rlist.get(i).getId();
            array.add(id);
            s+=id+" ";
        }
        for(int i=0; i< array.size(); i++){
            s+=Integer.toString(array.get(i))+" ";
        }
        JOptionPane.showMessageDialog(null, s);

        return list;*/

       // return dsl.select().from(RECEIPTS).join(RECEIPTTAG).on(RECEIPTS.ID.eq(RECEIPTTAG.ID)).fetchInto(RECEIPTS);

        //return dsl.selectFrom(RECEIPTS).fetch();
    //}
}
