package dao;
import generated.tables.Receipttag;
import generated.tables.records.ReceiptsRecord;
import generated.tables.records.ReceipttagRecord;
import org.jooq.*;
import org.jooq.impl.DSL;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.*;

import static com.google.common.base.Preconditions.checkState;
import static generated.Tables.RECEIPTS;
import static generated.Tables.RECEIPTTAG;
public class TagDAO {
    DSLContext dsl;

    public TagDAO(Configuration jooqConfig) {
        this.dsl = DSL.using(jooqConfig);
    }

    public void insertTag(String tag, Integer ID) {
        //Result rec = dsl.selectCount().from(RECEIPTTAG).where(RECEIPTTAG.ID.eq(ID)).and(RECEIPTTAG.RECEIPT_TAG.eq(tag)).fetch();
         Record rec=dsl.select().from(RECEIPTTAG).where(RECEIPTTAG.ID.eq(ID)).and(RECEIPTTAG.RECEIPT_TAG.eq(tag)).fetchOne();
        if (rec != null) {
            dsl.deleteFrom(RECEIPTTAG).where(RECEIPTTAG.ID.eq(ID)).and(RECEIPTTAG.RECEIPT_TAG.eq(tag)).execute();
        } else {
            dsl.insertInto(RECEIPTTAG, RECEIPTTAG.ID, RECEIPTTAG.RECEIPT_TAG)
                    .values(ID, tag)
                    .execute();
        }


        //checkState(receiptsRecord != null && receiptsRecord.getId() != null, "Insert failed");
    }

    public List<ReceiptsRecord> getTag() {


        return dsl.select().from(RECEIPTS).join(RECEIPTTAG).on(RECEIPTS.ID.eq(RECEIPTTAG.ID)).fetchInto(RECEIPTS);


    }

}
