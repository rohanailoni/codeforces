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
func solve(n int, arr []int) string {
	if arr[0] != n {
		return "No"
	}
	dp := make(map[int]int, 0)
	ans := make([]int, n)
	for i := 0; i < n; i++ {
		x := i + 1
		counter := 0
		var j int
		for j = 0; j < n; j++ {
			// if j > 0 && arr[j] != arr[j-1] {
			// 	if val, ok := dp[arr[j]]; ok {
			// 		dp[arr[j]] = counter
			// 		arr[i] = val
			// 		continue
			// 	} else {
			// 		if arr[j] >= x {
			// 			fmt.Println(counter)
			// 			counter++
			// 		}
			// 		dp[arr[j]] = counter
			// 	}

			// } else {
			if arr[j] >= x {
				counter++
			}
			dp[arr[j]] = counter
			//}

		}
		ans[i] = counter
		if arr[i] != ans[i] {
			return "No"
		}
	}
	//fmt.Println(ans, dp)
	return "Yes"
}
func solve1(n int, arr []int) string {
	if arr[0] != n {
		return "No"
	}
	dp := make(map[int]int, 0)
	ans := make([]int, n)
	for i := 0; i < n; i++ {
		x := i + 1
		val, ok := dp[x]
		counter := 0
		if ok {
			counter = val
		} else {
			var j int
			for j = 0; j < n; j++ {
				if arr[j] >= x {
					counter++
				}
				dp[arr[j]] = counter
				if j > 0 && arr[j] != arr[j-1] && arr[j-1]-arr[j]-1 > 0 {
					for al := arr[j-1] - 1; al > arr[j]; al-- {
						dp[al] = dp[al+1]
					}
				}

			}

		}

		ans[i] = counter
		//fmt.Println(ans, dp)
		if arr[i] != ans[i] {
			return "No"
		}
	}

	return "Yes"
}
func main() {
	testCases := readInt()
	ansarr := make([]string, testCases)
	for t := 0; t < testCases; t++ {
		n := readInt()
		arr := readInts(n)
		ansarr = append(ansarr, solve1(n, arr))

	}
	for _, val := range ansarr {
		fmt.Println(val)
	}
}
