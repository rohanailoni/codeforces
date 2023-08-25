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
func solve(carpet []string, n, m int) string {
	if m < 4 {
		return "No"
	}
	req := []byte{'v', 'i', 'k', 'a'}
	poi := 0
	for j := 0; j < m; j++ {
		for i := 0; i < n; i++ {
			if poi < 4 && carpet[i][j] == req[poi] {
				poi++
				break
			}
		}
	}
	//some comment to resubmit
	if poi >= 4 {
		return "Yes"
	} else {
		return "No"
	}
}
func main() {
	testCases := readInt()
	ansarr := make([]string, testCases)
	for t := 0; t < testCases; t++ {
		arr := readInts(2)
		n := arr[0]
		m := arr[1]
		carpet := make([]string, n)
		for i := 0; i < n; i++ {
			carpet[i] = readString()
		}
		ansarr = append(ansarr, solve(carpet, n, m))
	}
	for _, val := range ansarr {
		fmt.Println(val)
	}
}
