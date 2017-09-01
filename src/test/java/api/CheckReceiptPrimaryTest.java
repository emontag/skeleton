package api;
import generated.tables.records.ReceiptsRecord;
import io.dropwizard.jersey.validation.Validators;
import org.junit.Test;

import javax.validation.Validator;
import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;

public class CheckReceiptPrimaryTest {
    private final Validator validator = Validators.newValidator();

    @Test
    public void testPrimaryKey(){
        ReceiptsRecord rr=new ReceiptsRecord();
        rr.setId(100);
        validator.validate(rr);
        assertThat(validator.validate(rr), empty());
    }
}
