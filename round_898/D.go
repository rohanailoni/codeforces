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

func solve(n, k int, strip string) int64 {
	stripBytes := []byte(strip)
	i := 0
	j := k - 1
	var ans int64
	ans = 0
	for i < n && j < n {
		if stripBytes[i] == 'W' && j+1 < n {
			i++
			j++
			continue
		}
		//fmt.Println(i, j)
		//check if the window gor any blacks
		hasBlack := false
		for k := i; k < j+1; k++ {
			if stripBytes[k] == 'B' {
				stripBytes[k] = 'W'
				hasBlack = true
			}
		}
		if hasBlack {
			ans++
		}
		//fmt.Println(j+k, n)
		if j+k >= n {
			//fmt.Println("Kicked")
			i++
			j++

		} else {
			i = j + 1
			j = j + k
		}
		//fmt.Println(i, j)
	}
	return ans

}

func main() {
	testCases := readInt()
	ans := make([]int64, 0)
	for t := 0; t < testCases; t++ {
		arr := readInts(2)
		str := readString()
		ans = append(ans, solve(arr[0], arr[1], str))

	}
	for _, val := range ans {
		fmt.Println(val)
	}
}
