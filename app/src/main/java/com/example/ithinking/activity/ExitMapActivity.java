package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ithinking.R;

public class ExitMapActivity extends Activity {

    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit_map);

        //长按事件
        Button button = findViewById(R.id.event_2s);
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                registerForContextMenu(view);//弹出菜单注册
                openContextMenu(view);
                return true;
            }
        });
    }

    /**
     * 第一步：重写onKeyDown方法拦截用户单击后的退出事件
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(KeyEvent.KEYCODE_BACK == keyCode) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 第二步：创建退出方法exit()
     */
    private void exit() {
        if(System.currentTimeMillis() - exitTime > 2000) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        }else {
            finish();
            System.exit(0);//完全退出应用
        }
    }

    /**
     * 长按触发弹出菜单
     * 第一步：重写onCreateContextMenu菜单，为菜单添加选项值
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add("收藏");
        menu.add("举报");
    }
}
