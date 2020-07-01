package com.stuypulse.frc.robot.util;

import com.stuypulse.stuylib.math.Vector2D;
import com.stuypulse.stuylib.streams.IStream;

/**
 * <p>
 * Supplier interface for {@link com.stuypulse.stuylib.math.Vector2D}.
 * </p>
 *
 * Works like {@link com.stuypulse.stuylib.streams.IStream}, but for
 * {@link com.stuypulse.stuylib.math.Vector2D}
 *
 * @see {@link com.stuypulse.stuylib.streams.IStream}
 */
@FunctionalInterface
public interface VStream {
    Vector2D get();

    /*
     * public class DoubleIStream implements VStream {
     *
     * private final IStream a,b;
     *
     * public DoubleIStream(IStream a, IStream b) { this.a = a; this.b = b; }
     *
     * @Override public Vector2D get() { return new Vector2D(a.get(), b.get()); }
     *
     * }
     */

    public static VStream createVStream(IStream a, IStream b) {
        return () -> {
            return new Vector2D(a.get(), b.get());
        };
    }
}
