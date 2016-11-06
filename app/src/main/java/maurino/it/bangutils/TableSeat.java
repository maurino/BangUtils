package maurino.it.bangutils;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// Commento per prova git
public class TableSeat extends Activity {

    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_table_seat);
    }

    public void addPlayer(View viewx) {
        ViewGroup parent = (ViewGroup) findViewById(R.id.main_players);
        view = LayoutInflater.from(this).inflate(R.layout.player_item, parent, true);
        ((ViewGroup)((ViewGroup)view).getChildAt(((ViewGroup) view).getChildCount()-1)).getChildAt(1).requestFocus();
    }

    public void deletePlayer(View viewx) {
        LinearLayout r = (LinearLayout) ((ViewGroup) viewx.getParent()).getParent();
        r.removeView((LinearLayout) ((ViewGroup) viewx.getParent()));
    }
    public void assignSeat(View v) {
        List<String> players=new ArrayList<String>();
        String playerName="";
        ArrayList<View> result = new ArrayList<View>();

        ViewGroup viewGroup = (ViewGroup)((ViewGroup) v.getParent()).getParent();
        ViewGroup playersGRP=(ViewGroup)viewGroup.getChildAt(1);
        for (int i = 0; i < playersGRP.getChildCount(); i++) {
            View child = ((ViewGroup)(playersGRP.getChildAt(i))).getChildAt(1);
            EditText eTxt=(EditText)child;
            players.add(eTxt.getText().toString());
        }
        Collections.shuffle(players);
        TextView eTxt=(TextView) findViewById(R.id.players);
        StringBuilder sbPlayers=new StringBuilder();
        int counter=0;
        for (String player : players) {
            counter++;
            sbPlayers.append(counter).append(" ").append(player).append("\n");
        }
        eTxt.setText(sbPlayers.toString());
        ((Button)v).setEnabled(false);
    }
}

