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

func main() {
	testCases := readInt()
	for t := 0; t < testCases; t++ {
		n := readInt()
		arr := readInts(n)
		even := 0
		odd := 0

		for i := 0; i < n; i++ {
			if arr[i]%2 == 0 {
				even++
			} else {
				odd++
			}
		}
		if even > 0 && odd == 0 {
			fmt.Println("YES")
		} else if even == 0 && odd > 0 {
			if odd%2 == 0 {
				fmt.Println("Yes")
			} else {
				fmt.Println("No")
			}
		} else {
			if odd%2 == 0 {
				fmt.Println("Yes")
			} else {
				fmt.Println("No")
			}
		}

	}
}
