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
func findMin(arr []int) (int, int) {
	if len(arr) == 0 {

		return 0, 0
	}

	min := arr[0]
	index := 0
	for i := 1; i < len(arr); i++ {
		if arr[i] < min {
			min = arr[i]
			index = i
		}
	}

	return min, index
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
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
func solve(n int, arr []int) int {
	min, index := findMin(arr)
	arr[index] = min + 1
	ans := 1
	for i := 0; i < n; i++ {
		ans = ans * arr[i]
	}
	return ans
}
func main() {
	testCases := readInt()
	ans := make([]int, 0)
	for t := 0; t < testCases; t++ {
		n := readInt()
		arr := readInts(n)
		ans = append(ans, solve(n, arr))
		// my logic goes herefor each test case goes here
		// For example:
		// answer := yourFunction(arr)

		// Output the answer for each test case
		// fmt.Println(answer)
	}
	for _, val := range ans {
		fmt.Println(val)
	}
}
