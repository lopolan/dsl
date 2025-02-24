

package cn.yematech.heaver.api.filter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Filter class for {@link java.time.LocalDateTime} type attributes.
 *
 * @see RangeFilter
 */
public class LocalDateTimeFilter extends RangeFilter<LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * <p>Constructor for LocalDateTimeFilter.</p>
     */
    public LocalDateTimeFilter() {
    }

    /**
     * <p>Constructor for LocalDateTimeFilter.</p>
     *
     * @param filter a {@link LocalDateTimeFilter} object.
     */
    public LocalDateTimeFilter(final LocalDateTimeFilter filter) {
        super(filter);
    }

    /** {@inheritDoc} */
    @Override
    public LocalDateTimeFilter copy() {
        return new LocalDateTimeFilter(this);
    }

    /** {@inheritDoc} */
    @Override
    @DateTimeFormat(iso = ISO.DATE)
    public LocalDateTimeFilter setEquals(LocalDateTime equals) {
        super.setEquals(equals);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    @DateTimeFormat(iso = ISO.DATE)
    public LocalDateTimeFilter setNotEquals(LocalDateTime equals) {
        super.setNotEquals(equals);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    @DateTimeFormat(iso = ISO.DATE)
    public LocalDateTimeFilter setIn(List<LocalDateTime> in) {
        super.setIn(in);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    @DateTimeFormat(iso = ISO.DATE)
    public LocalDateTimeFilter setNotIn(List<LocalDateTime> notIn) {
        super.setNotIn(notIn);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    @DateTimeFormat(iso = ISO.DATE)
    public LocalDateTimeFilter setGreaterThan(LocalDateTime equals) {
        super.setGreaterThan(equals);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    @DateTimeFormat(iso = ISO.DATE)
    public LocalDateTimeFilter setLessThan(LocalDateTime equals) {
        super.setLessThan(equals);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    @DateTimeFormat(iso = ISO.DATE)
    public LocalDateTimeFilter setGreaterThanOrEqual(LocalDateTime equals) {
        super.setGreaterThanOrEqual(equals);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    @DateTimeFormat(iso = ISO.DATE)
    public LocalDateTimeFilter setLessThanOrEqual(LocalDateTime equals) {
        super.setLessThanOrEqual(equals);
        return this;
    }

}
