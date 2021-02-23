package thread

import (
	"fmt"
	"sync"
	"testing"
)

func TestLockGroup(t *testing.T)  {
	// 创建锁
	var mut sync.Mutex
	// 创建锁的组
	var wg sync.WaitGroup
	counter := 0
	for i:=0; i<5000;i++ {
		// 没启动一个协程，往里面加 1
		wg.Add(1)
		go func() {
			// 函数结束的时候释放锁
			defer func() {
				mut.Unlock()
			}()
			// 加锁
			mut.Lock()
			counter++
			// 协程结束时，组里面减少
			wg.Done()
		}()
	}
	// 等待组为空,这里就可以不用再用 sleep 了，效率更高
	wg.Wait()
	fmt.Println(counter)
}
