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
func solve(a, b, c int) int {
	isOnea := false
	isOneb := false
	isOnec := false
	overallone := 0
	if a == 1 {
		isOnea = true
		overallone += 1
	}
	if b == 1 {
		isOneb = true
		overallone += 1
	}
	if c == 1 {
		isOnec = true
		overallone += 1
	}
	if overallone == 3 {
		return 3
	}
	if overallone == 0 {
		return a * b * c
	}
	if overallone == 1 {
		if isOnea {
			return (a + b) * c
		}
		if isOneb {
			return max((a+b)*c, a*(b+c))
		}
		if isOnec {
			return (c + b) * a
		}
	}
	if overallone == 2 {
		if isOnea && isOneb {
			return (a + b) * c
		}
		if isOneb && isOnec {
			return a * (b + c)
		}
		if isOnea && isOnec {
			return a + b + c
		}
	}
	return 0

}
func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}
func main() {
	//testCases := readInt()
	for t := 0; t < 1; t++ {
		a := readInt()
		b := readInt()
		c := readInt()

		// my logic goes herefor each test case goes here
		// For example:
		// answer := yourFunction(arr)

		// Output the answer for each test case
		// fmt.Println(answer)
		fmt.Println(solve(a, b, c))
	}
}
