package com.stuypulse.frc.robot.util;

import com.stuypulse.stuylib.math.Vector2D;
import com.stuypulse.stuylib.streams.IStream;
import com.stuypulse.stuylib.streams.filters.IFilter;

/**
 * <p>
 * Supplier interface for {@link com.stuypulse.stuylib.math.Vector2D}.
 * </p>
 *
 * Works like {@link com.stuypulse.stuylib.streams.FilteredIStream}, but for
 * {@link com.stuypulse.stuylib.math.Vector2D}
 *
 * @see {@link com.stuypulse.stuylib.streams.FilteredIStream}
 */
public class FilteredVStream implements VStream {

    private final VStream input;

    private final IFilter xFilter;
    private final IFilter yFilter;

    public FilteredVStream(VStream input, IFilter xFilter, IFilter yFilter) {
        this.input = input;

        this.xFilter = xFilter;
        this.yFilter = yFilter;
    }

    public FilteredVStream(IStream xInput, IStream yInput, IFilter xFilter, IFilter yFilter) {
        this(VStream.createVStream(xInput, yInput), xFilter, yFilter);
    }

    public FilteredVStream(VStream input, IFilter filter) {
        this(input, filter, filter);
    }

    public FilteredVStream(IStream xInput, IStream yInput, IFilter filter) {
        this(VStream.createVStream(xInput, yInput), filter);
    }

    @Override
    public Vector2D get() {
        Vector2D vec = input.get();
        return new Vector2D(xFilter.get(vec.x), yFilter.get(vec.y));
    }

}
