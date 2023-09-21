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
func countSetBits(n int) int {
	count := 0
	for n > 0 {
		count += n & 1
		n >>= 1
	}
	return count
}
func main() {
	//testCases := readInt()
	for t := 0; t < 1; t++ {
		//n := readInt()
		arr := readInts(3)
		//n := arr[0]
		m := arr[1]
		k := arr[2]
		players := make([]int, m+1)
		for i := 0; i < m+1; i++ {
			players[i] = readInt()
			//fmt.Println(players)
		}
		fedor := players[m]
		count := 0
		for i := 0; i < m; i++ {
			//fmt.Println(countSetBits(fedor^players[i]), fedor, players, m+1)
			if countSetBits(fedor^players[i]) <= k {
				count++
			}
		}
		fmt.Println(count)
		// my logic goes herefor each test case goes here
		// For example:
		// answer := yourFunction(arr)

		// Output the answer for each test case
		// fmt.Println(answer)
	}
}
