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
func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	//testCases := readInt()
	ans := make([]string, 0)
	for t := 0; t < 1; t++ {
		//n := readInt()
		arr := readInts(2)
		//n := arr[0]
		x := min(arr[0], arr[1])
		//m := arr[1]
		if x%2 == 0 {
			ans = append(ans, "Malvika")
		} else {
			ans = append(ans, "Akshat")
		}
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
