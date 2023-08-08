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

func main() {
	testCases := readInt()
	for t := 0; t < testCases; t++ {
		n := readInt()
		str := strconv.FormatInt(int64(n), 10)
		len := len(str)
		byteArray := make([]string, len)
		for i, char := range str {
			byteArray[i] = string(char)
		}
		if len == 1 {
			if n >= 5 {
				fmt.Println("10")
			} else {
				fmt.Println(n)
			}
			continue
		}
		fmt.Println(byteArray)
		//byteArray[len-1] = "0"
		// for i := len - 2; i >= 0; i-- {
		// 	if x, _ := strconv.Atoi(byteArray[i+1]); x >= 5 {
		// 		if byteArray[i] == "9" {
		// 			temp := i - 1

		// 			for temp >= 0 {
		// 				if byteArray[temp] < "9" {
		// 					intVal, _ := strconv.Atoi(string(byteArray[temp]))
		// 					newVal := intVal + 1
		// 					byteArray[temp] = strconv.FormatInt(int64(newVal), 10)
		// 					break
		// 				} else {
		// 					temp -= 1
		// 				}
		// 			}
		// 			if temp < 0 {
		// 				byteArray = append([]string{"1"}, byteArray...)
		// 			}
		// 			fmt.Println(byteArray, i)
		// 		} else {
		// 			intVal, _ := strconv.Atoi(string(byteArray[i]))
		// 			newVal := intVal + 1
		// 			byteArray[i] = strconv.FormatInt(int64(newVal), 10)
		// 			byteArray[i+1] = "0"
		// 		}
		// 		if i == len-2 {
		// 			byteArray[len-1] = "0"
		// 		}

		// 	}
		// }
		pointer := len - 2
		for pointer >= 0 {
			//fmt.Println("Yes")
			if x, _ := strconv.Atoi(byteArray[pointer+1]); x >= 5 {

				if byteArray[pointer] == "9" {
					byteArray[pointer] = "0"
					byteArray[pointer+1] = "0"
					pointer--
					if pointer == -1 {
						byteArray = append([]string{"1"}, byteArray...)

					} else {
						for pointer >= 0 {
							intVal, _ := strconv.Atoi(string(byteArray[pointer]))
							if intVal < 9 {
								newVal := intVal + 1
								byteArray[pointer] = strconv.FormatInt(int64(newVal), 10)
								break
							} else {
								byteArray[pointer] = "0"
								pointer--
							}
						}
						if pointer < 0 {
							byteArray = append([]string{"1"}, byteArray...)
						}
					}

				} else {
					intVal, _ := strconv.Atoi(string(byteArray[pointer]))
					newVal := intVal + 1
					byteArray[pointer] = strconv.FormatInt(int64(newVal), 10)
					byteArray[pointer+1] = "0"
					pointer--

				}
			} else {
				pointer--
			}

		}

		fmt.Println(byteArray)

	}
}
