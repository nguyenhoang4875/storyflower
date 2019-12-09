/*
 * This file is generated by jOOQ.
 */
package storysflower.com.storysflower.model.tables.tables.records;


import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;

import storysflower.com.storysflower.model.tables.tables.Cart;


/**
 * cart table
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CartRecord extends UpdatableRecordImpl<CartRecord> implements Record8<Long, Long, Long, Long, Timestamp, Date, Time, Integer> {

    private static final long serialVersionUID = 840475844;

    /**
     * Setter for <code>public.cart.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.cart.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.cart.user_id</code>.
     */
    public void setUserId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.cart.user_id</code>.
     */
    public Long getUserId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.cart.customer_id</code>.
     */
    public void setCustomerId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.cart.customer_id</code>.
     */
    public Long getCustomerId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.cart.recipient_id</code>.
     */
    public void setRecipientId(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.cart.recipient_id</code>.
     */
    public Long getRecipientId() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>public.cart.buy_date</code>.
     */
    public void setBuyDate(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.cart.buy_date</code>.
     */
    public Timestamp getBuyDate() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>public.cart.delivery_date</code>.
     */
    public void setDeliveryDate(Date value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.cart.delivery_date</code>.
     */
    public Date getDeliveryDate() {
        return (Date) get(5);
    }

    /**
     * Setter for <code>public.cart.delivery_hour</code>.
     */
    public void setDeliveryHour(Time value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.cart.delivery_hour</code>.
     */
    public Time getDeliveryHour() {
        return (Time) get(6);
    }

    /**
     * Setter for <code>public.cart.status</code>.
     */
    public void setStatus(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.cart.status</code>.
     */
    public Integer getStatus() {
        return (Integer) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, Long, Long, Long, Timestamp, Date, Time, Integer> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, Long, Long, Long, Timestamp, Date, Time, Integer> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Cart.CART.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return Cart.CART.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return Cart.CART.CUSTOMER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field4() {
        return Cart.CART.RECIPIENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return Cart.CART.BUY_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field6() {
        return Cart.CART.DELIVERY_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Time> field7() {
        return Cart.CART.DELIVERY_HOUR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return Cart.CART.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getCustomerId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component4() {
        return getRecipientId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getBuyDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date component6() {
        return getDeliveryDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Time component7() {
        return getDeliveryHour();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getCustomerId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value4() {
        return getRecipientId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getBuyDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value6() {
        return getDeliveryDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Time value7() {
        return getDeliveryHour();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CartRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CartRecord value2(Long value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CartRecord value3(Long value) {
        setCustomerId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CartRecord value4(Long value) {
        setRecipientId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CartRecord value5(Timestamp value) {
        setBuyDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CartRecord value6(Date value) {
        setDeliveryDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CartRecord value7(Time value) {
        setDeliveryHour(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CartRecord value8(Integer value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CartRecord values(Long value1, Long value2, Long value3, Long value4, Timestamp value5, Date value6, Time value7, Integer value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CartRecord
     */
    public CartRecord() {
        super(Cart.CART);
    }

    /**
     * Create a detached, initialised CartRecord
     */
    public CartRecord(Long id, Long userId, Long customerId, Long recipientId, Timestamp buyDate, Date deliveryDate, Time deliveryHour, Integer status) {
        super(Cart.CART);

        set(0, id);
        set(1, userId);
        set(2, customerId);
        set(3, recipientId);
        set(4, buyDate);
        set(5, deliveryDate);
        set(6, deliveryHour);
        set(7, status);
    }
}
