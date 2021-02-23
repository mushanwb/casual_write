package thread

import (
	"fmt"
	"testing"
	"time"
)

func TestChan(t *testing.T)  {
	stop := make(chan int, 20)
	stop1 := make(chan int, 20)
	stop2 := make(chan int, 20)
	go worker(stop, stop1, stop2)
	time.Sleep(3 * time.Second)
	for i := 1; i < 21; i++ {
		i := i
		go func() {
			stop <- i
		}()
		go func() {
			stop1 <- i
		}()
		go func() {
			stop2 <- i
		}()
	}
	time.Sleep(100 * time.Second)
}

func worker(stop chan int, stop1 chan int, stop2 chan int)  {
	for {
		select {
		case num := <- stop:
			fmt.Println("stop1 值为： " , num)
			time.Sleep(1 * time.Second)

		case num1 := <- stop1:
			fmt.Println("stop2 值为： " , num1)
			time.Sleep(1 * time.Second)

		case num2 := <- stop2:
			fmt.Println("stop3 值为： " , num2)
			time.Sleep(1 * time.Second)

		default:
			fmt.Println("goroutine监控中...")
		}
	}
}