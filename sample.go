package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var scanner *bufio.Scanner

func initScanner() {
	scanner = bufio.NewScanner(os.Stdin)
	scanner.Split(bufio.ScanWords)
}

func readString() string {
	if scanner == nil {
		initScanner()
	}
	if scanner.Scan() {
		return scanner.Text()
	}
	return ""
}

func readInt() int {
	n, _ := strconv.Atoi(readString())
	return n
}

func readInts(n int) []int {
	arr := make([]int, n)
	for i := 0; i < n; i++ {
		arr[i] = readInt()
	}
	return arr
}
func readIntsUnknown() []int {
	var arr []int
	arr = make([]int, 0)
	for {
		num := readInt()
		if num == -1 {
			break
		}
		arr = append(arr, num)
	}
	return arr
}
func findMin(arr []int) int {
	if len(arr) == 0 {

		return 0
	}

	min := arr[0]

	for i := 1; i < len(arr); i++ {
		if arr[i] < min {
			min = arr[i]
		}
	}

	return min
}
func findMax(arr []int) int {
	if len(arr) == 0 {

		return 0
	}

	max := arr[0]

	for i := 1; i < len(arr); i++ {
		if arr[i] > max {
			max = arr[i]
		}
	}

	return max
}

type minheap struct {
	heap []int
}

func NewMinHeap() *minheap {
	return &minheap{
		heap: make([]int, 0),
	}
}

func (h *minheap) Insert(n int) {
	h.heap = append(h.heap, n)
	h.heapifyUp(len(h.heap) - 1)
}

func (h *minheap) heapifyUp(index int) {
	parentIdx := (index - 1) / 2
	for index > 0 && h.heap[parentIdx] > h.heap[index] {
		h.heap[parentIdx], h.heap[index] = h.heap[index], h.heap[parentIdx]
		index = parentIdx
		parentIdx = (index - 1) / 2
	}

}
func (h *minheap) heapifyDown(index int) {

	for {
		left := 2*index + 1
		right := 2*index + 2
		small := index

		if left < len(h.heap) && h.heap[left] < h.heap[small] {
			small = left
		}

		if right < len(h.heap) && h.heap[right] < h.heap[small] {
			small = right
		}
		if small == index {
			break
		}
		h.heap[small], h.heap[index] = h.heap[index], h.heap[small]
		index = small
	}
}
func (h *minheap) ExtractMin() int {
	min := h.heap[0]
	index := len(h.heap) - 1
	h.heap[0] = h.heap[index]
	h.heap = h.heap[:index]
	h.heapifyDown(0)
	return min
}
func (h *minheap) isEmpty() bool {
	if len(h.heap) == 0 {
		return true
	}
	return false
}
func (h *minheap) peak() int {
	return h.heap[0]
}
func cost(arr []int) int {
	return arr[len(arr)-1] - arr[0]
}
func solve(arr []int, n int, k int) int {
	heap := NewMinHeap()
	for i := 0; i < n; i++ {
		heap.Insert(arr[i])
	}
	//minEle := findMin(arr)
	maxEle := findMax(arr)
	ans := -1
	for !heap.isEmpty() {
		temp := make([]int, 0)
		for i := 0; i < k && !heap.isEmpty(); i++ {
			temp = append(temp, heap.ExtractMin())
		}
		temmin := temp[0]
		for !heap.isEmpty() && heap.peak()-temmin < maxEle-heap.peak() {
			temp = append(temp, heap.ExtractMin())
		}

		ans = max(ans, cost(temp))

	}
	return ans
}
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
func main() {
	testCases := readInt()
	for t := 0; t < testCases; t++ {
		n := readInt()
		arr := readInts(n)
		maxele := readInt()
		fmt.Println(solve(arr, n, maxele))
		// my logic goes herefor each test case goes here
		// For example:
		// answer := yourFunction(arr)

		// Output the answer for each test case
		// fmt.Println(answer)
	}
}
