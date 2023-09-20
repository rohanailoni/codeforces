package main

import (
	"bufio"
	"fmt"
	"math"
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
func solveQuadratic(a, b, c float64) (float64, bool) {
	discriminant := b*b - 4*a*c

	if discriminant < 0 {
		return 0, false
	}

	root1 := (-b + math.Sqrt(discriminant)) / (2 * a)
	root2 := (-b - math.Sqrt(discriminant)) / (2 * a)
	if root1 >= 0 {
		return root1, true
	}
	return root2, true
}
func main() {
	testCases := readInt()
	for t := 0; t < testCases; t++ {
		n := readInt()
		arr := readInts(n)
		var maper map[int]bool
		var unique []int
		unique = make([]int, 0)
		maper = make(map[int]bool, 0)
		x := -1 * 2 * n
		max := math.MaxInt64
		total, _ := solveQuadratic(1, -1, float64(x))
		for i := 0; i < n; i++ {
			if _, ok := maper[arr[i]]; !ok {
				maper[arr[i]] = true
				unique = append(unique, arr[i])
			}
		}
		diff := int(total) - len(unique)
		for i := 0; i < diff; i++ {
			unique = append(unique, max)
		}
		fmt.Println(unique)

	}
}
