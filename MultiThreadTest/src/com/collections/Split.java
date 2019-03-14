//package com.collections;
//
//import java.util.Collection;
//import java.util.Comparator;
//import java.util.Iterator;
//import java.util.Spliterator;
//import java.util.Spliterators.ArraySpliterator;
//import java.util.function.Consumer;
//
///**
// * A Spliterator using a given Iterator for element
// * operations. The spliterator implements {@code trySplit} to
// * permit limited parallelism.
// */
//class IteratorSpliterator<T> implements Spliterator<T> {
//    static final int BATCH_UNIT = 1 << 10;  // batch array size increment
//    static final int MAX_BATCH = 1 << 25;  // max batch array size;
//    private final Collection<? extends T> collection; // null OK
//    private Iterator<? extends T> it;
//    private final int characteristics;
//    private long est;             // size estimate
//    private int batch;            // batch size for splits
//
//    /**
//     * Creates a spliterator using the given given
//     * collection's {@link java.util.Collection#iterator()) for traversal,
//     * and reporting its {@link java.util.Collection#size()) as its initial
//     * size.
//     *
//     * @param c the collection
//     * @param characteristics properties of this spliterator's
//     *        source or elements.
//     */
//    public IteratorSpliterator(Collection<? extends T> collection, int characteristics) {
//        this.collection = collection;
//        this.it = null;
//        this.characteristics = (characteristics & Spliterator.CONCURRENT) == 0
//                               ? characteristics | Spliterator.SIZED | Spliterator.SUBSIZED
//                               : characteristics;
//    }
//
//    /**
//     * Creates a spliterator using the given iterator
//     * for traversal, and reporting the given initial size
//     * and characteristics.
//     *
//     * @param iterator the iterator for the source
//     * @param size the number of elements in the source
//     * @param characteristics properties of this spliterator's
//     * source or elements.
//     */
//    public IteratorSpliterator(Iterator<? extends T> iterator, long size, int characteristics) {
//        this.collection = null;
//        this.it = iterator;
//        this.est = size;
//        this.characteristics = (characteristics & Spliterator.CONCURRENT) == 0
//                               ? characteristics | Spliterator.SIZED | Spliterator.SUBSIZED
//                               : characteristics;
//    }
//
//    /**
//     * Creates a spliterator using the given iterator
//     * for traversal, and reporting the given initial size
//     * and characteristics.
//     *
//     * @param iterator the iterator for the source
//     * @param characteristics properties of this spliterator's
//     * source or elements.
//     */
//    public IteratorSpliterator(Iterator<? extends T> iterator, int characteristics) {
//        this.collection = null;
//        this.it = iterator;
//        this.est = Long.MAX_VALUE;
//        this.characteristics = characteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED);
//    }
//
//    @Override
//    public Spliterator<T> trySplit() {
//        /*
//         * Split into arrays of arithmetically increasing batch
//         * sizes.  This will only improve parallel performance if
//         * per-element Consumer actions are more costly than
//         * transferring them into an array.  The use of an
//         * arithmetic progression in split sizes provides overhead
//         * vs parallelism bounds that do not particularly favor or
//         * penalize cases of lightweight vs heavyweight element
//         * operations, across combinations of #elements vs #cores,
//         * whether or not either are known.  We generate
//         * O(sqrt(#elements)) splits, allowing O(sqrt(#cores))
//         * potential speedup.
//         */
//        Iterator<? extends T> i;
//        long s;
//        if ((i = it) == null) {
//            i = it = collection.iterator();
//            s = est = (long) collection.size();
//        }
//        else
//            s = est;
//        if (s > 1 && i.hasNext()) {
//            int n = batch + BATCH_UNIT;
//            if (n > s)
//                n = (int) s;
//            if (n > MAX_BATCH)
//                n = MAX_BATCH;
//            Object[] a = new Object[n];
//            int j = 0;
//            do { a[j] = i.next(); } while (++j < n && i.hasNext());
//            batch = j;
//            if (est != Long.MAX_VALUE)
//                est -= j;
//            return new ArraySpliterator<>(a, 0, j, characteristics);
//        }
//        return null;
//    }
//
//    @Override
//    public void forEachRemaining(Consumer<? super T> action) {
//        if (action == null) throw new NullPointerException();
//        Iterator<? extends T> i;
//        if ((i = it) == null) {
//            i = it = collection.iterator();
//            est = (long)collection.size();
//        }
//        i.forEachRemaining(action);
//    }
//
//    @Override
//    public boolean tryAdvance(Consumer<? super T> action) {
//        if (action == null) throw new NullPointerException();
//        if (it == null) {
//            it = collection.iterator();
//            est = (long) collection.size();
//        }
//        if (it.hasNext()) {
//            action.accept(it.next());
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public long estimateSize() {
//        if (it == null) {
//            it = collection.iterator();
//            return est = (long)collection.size();
//        }
//        return est;
//    }
//
//    @Override
//    public int characteristics() { return characteristics; }
//
//    @Override
//    public Comparator<? super T> getComparator() {
//        if (hasCharacteristics(Spliterator.SORTED))
//            return null;
//        throw new IllegalStateException();
//    }
//}