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
		//we will use the the 2 pointer method the same way we use in quick sort to sort the array
		main := 0 // this will maintain the status of the
		ans := 0
		for i := 0; i < n; i++ {
			if arr[i] == i+1 {
				main = i
				break
			}
		}
		//fmt.Println(main)
		for mover := main + 1; mover < n && main < n; mover++ {
			if arr[mover] == (mover + 1) {

				if main != mover {
					arr[mover], arr[main] = arr[main], arr[mover]
					main += 1
					ans += 1
					for main < n && arr[main] != main+1 {
						main += 1
					}
				}
				//main += 1
				//fmt.Println(main, arr, "first")

				//fmt.Println(main, arr, "end")

			}

		}
		fmt.Println(arr, ans)
	}
}
