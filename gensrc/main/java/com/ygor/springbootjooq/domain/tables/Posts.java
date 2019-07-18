/*
 * This file is generated by jOOQ.
 */
package com.ygor.springbootjooq.domain.tables;


import com.ygor.springbootjooq.domain.Indexes;
import com.ygor.springbootjooq.domain.Keys;
import com.ygor.springbootjooq.domain.Public;
import com.ygor.springbootjooq.domain.tables.records.PostsRecord;

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
public class Posts extends TableImpl<PostsRecord> {

    private static final long serialVersionUID = -1940212516;

    /**
     * The reference instance of <code>public.posts</code>
     */
    public static final Posts POSTS = new Posts();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PostsRecord> getRecordType() {
        return PostsRecord.class;
    }

    /**
     * The column <code>public.posts.id</code>.
     */
    public final TableField<PostsRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('posts_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.posts.title</code>.
     */
    public final TableField<PostsRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * The column <code>public.posts.content</code>.
     */
    public final TableField<PostsRecord, String> CONTENT = createField("content", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.posts.created_on</code>.
     */
    public final TableField<PostsRecord, Timestamp> CREATED_ON = createField("created_on", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * Create a <code>public.posts</code> table reference
     */
    public Posts() {
        this(DSL.name("posts"), null);
    }

    /**
     * Create an aliased <code>public.posts</code> table reference
     */
    public Posts(String alias) {
        this(DSL.name(alias), POSTS);
    }

    /**
     * Create an aliased <code>public.posts</code> table reference
     */
    public Posts(Name alias) {
        this(alias, POSTS);
    }

    private Posts(Name alias, Table<PostsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Posts(Name alias, Table<PostsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Posts(Table<O> child, ForeignKey<O, PostsRecord> key) {
        super(child, key, POSTS);
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
        return Arrays.<Index>asList(Indexes.POSTS_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<PostsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_POSTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<PostsRecord> getPrimaryKey() {
        return Keys.POSTS_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PostsRecord>> getKeys() {
        return Arrays.<UniqueKey<PostsRecord>>asList(Keys.POSTS_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Posts as(String alias) {
        return new Posts(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Posts as(Name alias) {
        return new Posts(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Posts rename(String name) {
        return new Posts(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Posts rename(Name name) {
        return new Posts(name, null);
    }
}
