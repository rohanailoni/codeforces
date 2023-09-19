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
func solve(s string) string {

	// n := len(s)
	// i := 0
	// ans := ""
	// for i+3 < n {
	// 	if s[i:i+3] == "WUB" {
	// 		i = i + 3
	// 		if ans != "" {
	// 			ans += string(" ")
	// 		}

	// 	} else {
	// 		ans += string(s[i])
	// 		i += 1
	// 	}
	// }

	// red := string(s[i]) + string(s[i+1]) + string(s[i+2])
	// //fmt.Println(red)
	// //remove front space
	// if red != "WUB" {
	// 	return ans + red
	// }
	// return ans
	n := len(s)
	i := 0
	ans := ""
	skipSpace := true // Flag to skip adding space after "WUB"

	for i+2 < n {
		if s[i:i+3] == "WUB" {
			i = i + 3
			if !skipSpace && ans != "" {
				ans += " "
			}
			skipSpace = true
		} else {
			ans += string(s[i])
			i++
			skipSpace = false
		}
	}

	// Handle the remaining characters
	for i < n {
		ans += string(s[i])
		i++
		skipSpace = false
	}

	return ans

}
func main() {
	//testCases := readInt()
	ans := make([]string, 0)
	for t := 0; t < 1; t++ {
		//n := readInt()
		arr := readString()

		// my logic goes herefor each test case goes here
		// For example:
		// answer := yourFunction(arr)

		// Output the answer for each test case
		// fmt.Println(answer)
		ans = append(ans, solve(arr))
	}
	for _, val := range ans {
		fmt.Println(val)
	}
}
