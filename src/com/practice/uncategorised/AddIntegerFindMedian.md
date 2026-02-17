# Add Integer & Find Median

Maintain two heaps to track a running median:
- `maxHeap` (a max-heap) stores the lower half of numbers
- `minHeap` (a min-heap) stores the upper half of numbers

## Idea
Keep the two heaps balanced so their sizes differ by at most one. Insert each new integer into the appropriate heap, rebalance if needed, and compute the median in O(1).

## Operations

### addInteger(i)
- If `maxHeap` is empty: add `i` to `maxHeap`.
- Else if `i <= maxHeap.peek()`: `maxHeap.add(i)`
- Else: `minHeap.add(i)`
- If `abs(maxHeap.size() - minHeap.size()) >= 2`: call `rebalance()`

### rebalance()
- If `maxHeap.size() > minHeap.size()`: move `maxHeap.peek()` to `minHeap`
- Else: move `minHeap.peek()` to `maxHeap`

### findMedian()
- If `maxHeap.size() > minHeap.size()`: return `maxHeap.peek()` as median
- Else if `minHeap.size() > maxHeap.size()`: return `minHeap.peek()` as median
- Else (sizes equal): return `(maxHeap.peek() + minHeap.peek()) / 2.0`

## Pseudocode

    // addInteger(i)
    if maxHeap.isEmpty()
        maxHeap.add(i)
    else if i <= maxHeap.peek()
        maxHeap.add(i)
    else
        minHeap.add(i)
  
    if abs(maxHeap.size() - minHeap.size()) >= 2
        rebalance()
  
    // rebalance()
    if maxHeap.size() > minHeap.size()
        value = maxHeap.poll()
        minHeap.add(value)
    else
        value = minHeap.poll()
        maxHeap.add(value)
  
    // findMedian()
    if maxHeap.size() > minHeap.size()
        return maxHeap.peek()
    else if minHeap.size() > maxHeap.size()
        return minHeap.peek()
    else
        return (maxHeap.peek() + minHeap.peek()) / 2.0

## Complexity
- Insertion: O(log n)
- Rebalance: O(log n) (occurs at most once per insert)
- Finding median: O(1)
- Space: O(n)

## Notes
- Use double for median when averaging two integers to avoid integer division.
- Handle equal elements and negative numbers naturally with heaps.