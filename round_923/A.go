package main

import (
	"bufio"
	"fmt"
	"math"
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
func solve(n, k int) []int {
	ans := make([]int, n)
	for i := 0; i < n; i++ {
		ans[i] = 0
	}
	numPointer := 1

	for i := 0; i < k; i++ {
		j := i
		for {
			if (j) >= n {
				//fmt.Println(j + k)
				break
			}
			ans[j] = numPointer
			j = j + k
			numPointer++

		}
	}
	return ans
}
func printArrayWithSpaces(arr []int) {
	arrayString := strings.Trim(strings.Join(strings.Fields(fmt.Sprint(arr)), " "), "[]")
	fmt.Println(arrayString)
}
func check(arr []int, n, k int) bool {
	diff := make([]int, n-k+1)
	// min := findMin(arr)
	// max := findMax(arr)
	// if max-min <= 1 {
	// 	return true
	// }
	// return false
	for i := 0; i < n-k+1; i++ {
		sum := 0
		high := i + k
		for j := i; j < high; j++ {
			sum += arr[j]
			fmt.Print(arr[j], " ")
		}
		fmt.Println("")
		diff[i] = sum
	}
	fmt.Println(diff)
	for i := 0; i < len(diff); i++ {
		for j := i + 1; j < len(diff); j++ {
			if math.Abs(float64(diff[i]-diff[j])) > 1 {
				return false
			}
		}
	}
	return true
}
func main() {
	testCases := readInt()
	for t := 0; t < testCases; t++ {
		//n := readInt()
		arr := readInts(2)
		n := arr[0]
		k := arr[1]
		ans := solve(n, k)
		fmt.Println(check(ans, n, k), ans)
		//printArrayWithSpaces(ans)

	}
}
