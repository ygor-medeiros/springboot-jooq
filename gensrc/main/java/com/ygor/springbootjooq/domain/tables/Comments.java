/*
 * This file is generated by jOOQ.
 */
package com.ygor.springbootjooq.domain.tables;


import com.ygor.springbootjooq.domain.Indexes;
import com.ygor.springbootjooq.domain.Keys;
import com.ygor.springbootjooq.domain.Public;
import com.ygor.springbootjooq.domain.tables.records.CommentsRecord;

import java.sql.Timestamp;
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


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Comments extends TableImpl<CommentsRecord> {

    private static final long serialVersionUID = -1526738471;

    /**
     * The reference instance of <code>public.comments</code>
     */
    public static final Comments COMMENTS = new Comments();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CommentsRecord> getRecordType() {
        return CommentsRecord.class;
    }

    /**
     * The column <code>public.comments.id</code>.
     */
    public final TableField<CommentsRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('comments_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.comments.post_id</code>.
     */
    public final TableField<CommentsRecord, Integer> POST_ID = createField("post_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.comments.name</code>.
     */
    public final TableField<CommentsRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    /**
     * The column <code>public.comments.email</code>.
     */
    public final TableField<CommentsRecord, String> EMAIL = createField("email", org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    /**
     * The column <code>public.comments.content</code>.
     */
    public final TableField<CommentsRecord, String> CONTENT = createField("content", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.comments.created_on</code>.
     */
    public final TableField<CommentsRecord, Timestamp> CREATED_ON = createField("created_on", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * Create a <code>public.comments</code> table reference
     */
    public Comments() {
        this(DSL.name("comments"), null);
    }

    /**
     * Create an aliased <code>public.comments</code> table reference
     */
    public Comments(String alias) {
        this(DSL.name(alias), COMMENTS);
    }

    /**
     * Create an aliased <code>public.comments</code> table reference
     */
    public Comments(Name alias) {
        this(alias, COMMENTS);
    }

    private Comments(Name alias, Table<CommentsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Comments(Name alias, Table<CommentsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Comments(Table<O> child, ForeignKey<O, CommentsRecord> key) {
        super(child, key, COMMENTS);
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
        return Arrays.<Index>asList(Indexes.COMMENTS_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<CommentsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_COMMENTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CommentsRecord> getPrimaryKey() {
        return Keys.COMMENTS_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CommentsRecord>> getKeys() {
        return Arrays.<UniqueKey<CommentsRecord>>asList(Keys.COMMENTS_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<CommentsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CommentsRecord, ?>>asList(Keys.COMMENTS__COMMENTS_POST_ID_FKEY);
    }

    public Posts posts() {
        return new Posts(this, Keys.COMMENTS__COMMENTS_POST_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Comments as(String alias) {
        return new Comments(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Comments as(Name alias) {
        return new Comments(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Comments rename(String name) {
        return new Comments(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Comments rename(Name name) {
        return new Comments(name, null);
    }
}
