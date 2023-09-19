package main

import (
	"bufio"
	"fmt"
	"math"
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
func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}
func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
func solve(arr []int) int {
	n := len(arr)
	minIndex := 0
	maxIndex := 0
	maxValue := math.MinInt64
	minValue := math.MaxInt64
	for i := n - 1; i >= 0; i-- {
		if arr[i] >= maxValue {
			maxValue = arr[i]
			maxIndex = i
		}
	}
	for i := 0; i < n; i++ {
		if arr[i] <= minValue {
			minValue = arr[i]
			minIndex = i
		}
	}
	if minValue == maxValue {
		return 0
	}
	//fmt.Println(maxIndex, minIndex, maxValue, minValue)
	ans := 0
	if minIndex < maxIndex {
		minIndex += 1

	}

	ans += maxIndex
	ans += (n - minIndex - 1)
	return ans
}
func main() {

	for t := 0; t < 1; t++ {
		n := readInt()
		arr := readInts(n)
		fmt.Println(solve(arr))
	}
}
