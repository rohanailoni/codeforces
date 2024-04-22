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
func printArrayWithSpaces(arr []int) {
	// Convert the array to a string with spaces
	arrayString := strings.Trim(strings.Join(strings.Fields(fmt.Sprint(arr)), " "), "[]")

	// Print the formatted string
	fmt.Println(arrayString)
}
func sum(arr []int) int {
	ans := 0
	for i := 0; i < len(arr); i++ {
		ans += arr[i]
	}
	return ans
}
func solve(a, b, c int) int {
	level := 0
	levelnodes := 1
	if c != a+1 {
		return -1
	}
	for {
		count_of_treee_nodes := 0
		//fmt.Println(level, levelnodes, a, b, c)
		if a == 0 && b == 0 && c == 0 {
			if levelnodes > 0 {
				return -1
			}
			return level - 1
		}
		for i := 0; i < levelnodes; i++ {
			//touch := false
			if a > 0 {
				//touch = true
				a = a - 1
				count_of_treee_nodes += 2
			} else if b > 0 {
				//touch = true
				b = b - 1
				count_of_treee_nodes += 1
			} else if c > 0 {
				//touch = true
				c = c - 1
				count_of_treee_nodes += 0
			}

		}
		if levelnodes == 0 {
			return -1
		}
		level++
		levelnodes = count_of_treee_nodes
	}

}
func main() {
	testCases := readInt()
	ans := make([]int, 0)
	for t := 0; t < testCases; t++ {

		arr := readInts(3)
		a := arr[0]
		b := arr[1]
		c := arr[2]
		ans = append(ans, solve(a, b, c))

	}
	for i := 0; i < testCases; i++ {
		fmt.Println(ans[i])
	}
}
