package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
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

func main() {
	testCases := readInt()
	for t := 0; t < testCases; t++ {
		n := readInt()
		arr := readInts(n)

		// my logic goes herefor each test case goes here
		// For example:
		// answer := yourFunction(arr)

		// Output the answer for each test case
		// fmt.Println(answer)
	}
}

