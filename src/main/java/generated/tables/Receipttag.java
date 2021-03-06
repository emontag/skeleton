/**
 * This class is generated by jOOQ
 */
package generated.tables;


import generated.Keys;
import generated.Public;
import generated.tables.records.ReceipttagRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Receipttag extends TableImpl<ReceipttagRecord> {

	private static final long serialVersionUID = 893567334;

	/**
	 * The reference instance of <code>public.receipttag</code>
	 */
	public static final Receipttag RECEIPTTAG = new Receipttag();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<ReceipttagRecord> getRecordType() {
		return ReceipttagRecord.class;
	}

	/**
	 * The column <code>public.receipttag.id</code>.
	 */
	public final TableField<ReceipttagRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>public.receipttag.receipt_tag</code>.
	 */
	public final TableField<ReceipttagRecord, String> RECEIPT_TAG = createField("receipt_tag", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * Create a <code>public.receipttag</code> table reference
	 */
	public Receipttag() {
		this("receipttag", null);
	}

	/**
	 * Create an aliased <code>public.receipttag</code> table reference
	 */
	public Receipttag(String alias) {
		this(alias, RECEIPTTAG);
	}

	private Receipttag(String alias, Table<ReceipttagRecord> aliased) {
		this(alias, aliased, null);
	}

	private Receipttag(String alias, Table<ReceipttagRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<ReceipttagRecord> getPrimaryKey() {
		return Keys.CONSTRAINT_2;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<ReceipttagRecord>> getKeys() {
		return Arrays.<UniqueKey<ReceipttagRecord>>asList(Keys.CONSTRAINT_2);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Receipttag as(String alias) {
		return new Receipttag(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Receipttag rename(String name) {
		return new Receipttag(name, null);
	}
}
