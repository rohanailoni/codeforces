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
	x := readString()
	n, _ := strconv.Atoi(x)
	return n
}
func readIntsUnknown() []int {
	var arr []int
	arr = make([]int, 0)
	for {
		num := readInt()
		fmt.Println(num)
		if num == -1 {
			break
		}
		arr = append(arr, n2um)
	}
	return arr
}
func readInts(n int) []int {
	arr := make([]int, n)
	for i := 0; i < n; i++ {
		arr[i] = readInt()
	}
	return arr
}

func main() {
	//testCases := readInt()
	for t := 0; t < 1; t++ {
		n := readInt()
		X := readIntsUnknown()
		fmt.Println(n, X)
		// Y := readIntsUnknown()
		// var cache []int
		// cache = make([]int, n)
		// for i := 0; i < len(X); i++ {
		// 	cache[X[i]]++
		// }
		// for i := 0; i < len(Y); i++ {
		// 	cache[Y[i]]++
		// }
		// count := 0
		// for i := 0; i < n; i++ {
		// 	if cache[i] != 0 {
		// 		count++
		// 	}
		// }
		// if count == n {
		// 	fmt.Println("I become the guy.")
		// } else {
		// 	fmt.Println("Oh, my keyboard!")
		// }
		// my logic goes herefor each test case goes here
		// For example:
		// answer := yourFunction(arr)

		// Output the answer for each test case
		// fmt.Println(answer)
	}
}
