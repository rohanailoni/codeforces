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
func orderOfInteger(n int) int {
	if n <= 0 {
		return 0
	}

	order := int(math.Floor(math.Log2(float64(n))) + 1)
	return order
}
func maxIntegerInOrder(order int) int {
	if order <= 0 {
		return 0
	}

	maxValue := int(math.Pow(2, float64(order))) - 1
	return maxValue
}

func solve(n, k int) []int {

	ans := make([]int, 0)
	if n == 1 {
		ans = append(ans, k)
		return ans
	}
	maxbits := orderOfInteger(k)
	n = n - 1
	rem := k
	firstNumber := 1 << (maxbits - 1)
	rem = rem - firstNumber
	ans = append(ans, firstNumber)
	sumcall := 0
	for i := 0; i < n-2; i++ {
		num := maxIntegerInOrder(i + 1)
		if rem-num >= 0 {
			ans = append(ans, num)
			sumcall += num
		} else {
			ans = append(ans, 0)
		}
	}
	diff := rem - sumcall

	ans = append(ans, diff)
	//fmt.Println(ans)
	return ans
}
func solve2(n, k int) []int {
	ans := make([]int, n)
	if n == 1 {
		ans[0] = k
		return ans
	}
	maxbits := 0
	maxbits = orderOfInteger(k)
	maxbits = maxbits - 1
	ans[0] = (1 << maxbits) - 1
	ans[1] = k - ans[0]
	for i := 2; i < n; i++ {
		ans[i] = 0
	}
	return ans
}
func main() {
	testCases := readInt()
	//ans := make([][]int, testCases)
	for t := 0; t < testCases; t++ {

		arr := readInts(2)
		n := arr[0]
		k := arr[1]
		printArrayWithSpaces(solve2(n, k))

	}

}
