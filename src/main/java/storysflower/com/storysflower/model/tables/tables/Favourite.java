/*
 * This file is generated by jOOQ.
 */
package storysflower.com.storysflower.model.tables.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import storysflower.com.storysflower.model.tables.Indexes;
import storysflower.com.storysflower.model.tables.Keys;
import storysflower.com.storysflower.model.tables.Public;
import storysflower.com.storysflower.model.tables.tables.records.FavouriteRecord;


/**
 * favourite table
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Favourite extends TableImpl<FavouriteRecord> {

    private static final long serialVersionUID = -857555900;

    /**
     * The reference instance of <code>public.favourite</code>
     */
    public static final Favourite FAVOURITE = new Favourite();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FavouriteRecord> getRecordType() {
        return FavouriteRecord.class;
    }

    /**
     * The column <code>public.favourite.id</code>.
     */
    public final TableField<FavouriteRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('favourite_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.favourite.product_id</code>.
     */
    public final TableField<FavouriteRecord, Long> PRODUCT_ID = createField("product_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.favourite.user_id</code>.
     */
    public final TableField<FavouriteRecord, Long> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.favourite.value</code>.
     */
    public final TableField<FavouriteRecord, Boolean> VALUE = createField("value", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("false", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * Create a <code>public.favourite</code> table reference
     */
    public Favourite() {
        this(DSL.name("favourite"), null);
    }

    /**
     * Create an aliased <code>public.favourite</code> table reference
     */
    public Favourite(String alias) {
        this(DSL.name(alias), FAVOURITE);
    }

    /**
     * Create an aliased <code>public.favourite</code> table reference
     */
    public Favourite(Name alias) {
        this(alias, FAVOURITE);
    }

    private Favourite(Name alias, Table<FavouriteRecord> aliased) {
        this(alias, aliased, null);
    }

    private Favourite(Name alias, Table<FavouriteRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("favourite table"));
    }

    public <O extends Record> Favourite(Table<O> child, ForeignKey<O, FavouriteRecord> key) {
        super(child, key, FAVOURITE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PK_FAVOURITE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<FavouriteRecord, Long> getIdentity() {
        return Keys.IDENTITY_FAVOURITE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<FavouriteRecord> getPrimaryKey() {
        return Keys.PK_FAVOURITE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<FavouriteRecord>> getKeys() {
        return Arrays.<UniqueKey<FavouriteRecord>>asList(Keys.PK_FAVOURITE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<FavouriteRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<FavouriteRecord, ?>>asList(Keys.FAVOURITE__FK_FAVOURITE_PRODUCT);
    }

    public Product product() {
        return new Product(this, Keys.FAVOURITE__FK_FAVOURITE_PRODUCT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Favourite as(String alias) {
        return new Favourite(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Favourite as(Name alias) {
        return new Favourite(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Favourite rename(String name) {
        return new Favourite(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Favourite rename(Name name) {
        return new Favourite(name, null);
    }
}
