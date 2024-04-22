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
func solve(n int) string {
	arr := make([]int, 3)
	alpha := "abcdefghijklmnopqrstuvwxyz"

	for i := 1; i < 27; i++ {
		for j := 1; j < 27; j++ {
			for k := 1; k < 27; k++ {
				if i+j+k == n {
					arr[0] = i
					arr[1] = j
					arr[2] = k
					break
				}
			}
		}
	}

	return string(alpha[arr[2]-1]) + string(alpha[arr[1]-1]) + string(alpha[arr[0]-1])
}
func main() {
	testCases := readInt()
	for t := 0; t < testCases; t++ {
		n := readInt()
		fmt.Println(solve(n))
	}
}
