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
func solve(s [][]int, n int) int {
	ans := 0
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if i != j {
				if s[i][0] == s[j][1] {
					ans++
				}
			}
		}
	}
	return ans
}
func main() {
	//testCases := readInt()
	ans := make([]int, 0)
	for t := 0; t < 1; t++ {
		n := readInt()
		teams := make([][]int, 0)
		for i := 0; i < n; i++ {
			teams = append(teams, readInts(2))
		}
		ans = append(ans, solve(teams, n))
	}
	for _, val := range ans {
		fmt.Println(val)
	}
}
