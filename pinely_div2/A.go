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
func solve(coordinates [][]int) bool {
	n := len(coordinates)
	ispositiveAndNegativeX := false
	ispositiveAndNegativeY := false
	var isposX string

	if coordinates[0][0] >= 0 {
		isposX = "P"
	} else {
		isposX = "N"
	}

	for i := 1; i < n; i++ {
		if isposX == "P" && coordinates[i][0] < 0 {
			isposX = "N"
			ispositiveAndNegativeX = true
			break
		}
		if isposX == "N" && coordinates[i][0] >= 0 {
			isposX = "P"
			ispositiveAndNegativeX = true
			break
		}

	}
	if !ispositiveAndNegativeX {
		return true
	}
	var isPosY string
	if coordinates[0][1] >= 0 {
		isPosY = "P"
	} else {
		isPosY = "N"
	}
	for i := 1; i < n; i++ {
		if isPosY == "P" && coordinates[i][1] < 0 {
			isPosY = "N"
			ispositiveAndNegativeY = true
			break
		}
		if isPosY == "N" && coordinates[i][1] >= 0 {
			isPosY = "P"
			ispositiveAndNegativeY = true
			break
		}
	}
	if ispositiveAndNegativeY && ispositiveAndNegativeX {
		return false
	}
	return true

}
func main() {
	testCases := readInt()
	for t := 0; t < testCases; t++ {
		n := readInt()
		var coordinates [][]int
		for i := 0; i < n; i++ {
			coordinates = append(coordinates, readInts(2))
		}
		if solve(coordinates) {
			fmt.Println("Yes")
		} else {
			fmt.Println("No")
		}

	}
}
