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
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
func solve(a string) bool {
	if a[0] == 'a' && a[1] == 'b' && a[2] == 'c' {
		return true
	}
	anyPos := false
	if a[0] == 'a' || a[1] == 'b' || a[2] == 'c' {
		anyPos = true
	}
	return anyPos
}
func main() {
	testCases := readInt()
	ans := make([]string, 0)
	for t := 0; t < testCases; t++ {
		// n := readInt()
		// arr := readInts(n)
		str := readString()
		if solve(str) {
			ans = append(ans, "Yes")
		} else {
			ans = append(ans, "No")
		}

	}
	for _, val := range ans {
		fmt.Println(val)
	}
}
