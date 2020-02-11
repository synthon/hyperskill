interface Multiset<E> {

    /**
     * Add an element to the multiset.
     * It increases the multiplicity of the element by 1.
     */
    void add(E elem);

    /**
     * Remove an element from the multiset.
     * It decreases the multiplicity of the element by 1.
     */
    void remove(E elem);

    /**
     * Union this multiset with another one. The result is the modified multiset (this).
     * It will contain all elements that are present in at least one of the initial multisets.
     * The multiplicity of each element is equal to the maximum multiplicity of
     * the corresponding elements in both multisets.
     */
    void union(Multiset<E> other);

    /**
     * Intersect this multiset with another one. The result is the modified multiset (this).
     * It will contain all elements that are present in the both multisets.
     * The multiplicity of each element is equal to the minimum multiplicity of
     * the corresponding elements in the intersecting multisets.
     */
    void intersect(Multiset<E> other);

    /**
     * Returns multiplicity of the given element.
     * If the set doesn't contain it, the multiplicity is 0
     */
    int getMultiplicity(E elem);

    /**
     * Check the multiset contains an element,
     * i.e. the multiplicity > 0
     */
    boolean contains(E elem);

    /**
     * The number of unique elements
     */
    int numberOfUniqueElements();

    /**
     * The size of the multiset, including repeated elements
     */
    int size();

    /**
     * The set of unique elements (without repeating)
     */
    Set<E> toSet();
}

class HashMultiset<E> implements Multiset<E> {

    private Map<E, Integer> map = new HashMap<>();

    @Override
    public void add(E elem) {
        map.put(elem, map.getOrDefault(elem, 0) + 1);
    }

    @Override
    public void remove(E elem) {
        Boolean contains = map.containsKey(elem);

        if (contains) {
            map.put(elem, map.get(elem) - 1);
        }

        if (contains && map.get(elem) == 0) {
            map.remove(elem);
        }

    }

    @Override
    public void union(Multiset<E> other) {
        other.toSet().forEach(elem -> map.put(elem, Math.max(other.getMultiplicity(elem),
                                                              this.getMultiplicity(elem))));
    }

    @Override
    public void intersect(Multiset<E> other) {
        Set<E> keys = new HashSet<>(map.keySet());

        for (E elem : keys) {
            if (other.contains(elem)) {
                map.put(elem, Math.min(other.getMultiplicity(elem),
                                        this.getMultiplicity(elem)));
            } else {
                map.remove(elem);
            }
        }
    }

    @Override
    public int getMultiplicity(E elem) {
        return map.getOrDefault(elem, 0);
    }

    @Override
    public boolean contains(E elem) {
        return map.containsKey(elem);
    }

    @Override
    public int numberOfUniqueElements() {
        return map.size();
    }

    @Override
    public int size() {
        return map.values().stream().reduce(0, (a, b) -> a + b);
    }

    @Override
    public Set<E> toSet() {
        return map.keySet();
    }
}
