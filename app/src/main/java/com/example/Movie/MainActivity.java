package com.example.Movie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CustomAdapter customAdapter = new CustomAdapter();
    ListView listView;

    int[] IMAGES = {
            R.drawable.parasite,
            R.drawable.mulan,
            R.drawable.quiet,
            R.drawable.frozen,
            R.drawable.end,
            R.drawable.ad,
            R.drawable.little,
    };

    String[] TITLES = {
            "Parasite (2019)",
            "MuLan (2020)",
            "A Quiet Place Part2 (2020)",
            "Frozen (2019)",
            "Avengers: Endgame (2019)",
            "AD ASTRA (2019)",
            "Little Woman (2019)"
    };

    String[] DESCRIPTIONS = {
            "A poor family, the Kims, con their way into becoming the servants of a rich family, the Parks. But their easy life gets complicated when their deception is threatened with exposure.",
            "A young Chinese maiden disguises herself as a male warrior in order to save her father. A live-action feature film based on Disney's 'Mulan.'",
            "Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, ..",
            "Anna, Elsa, Kristoff, Olaf and Sven leave Arendelle to travel to an ancient, autumn-bound forest of an enchanted land..",
            "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies,..",
            "Astronaut Roy McBride undertakes a mission across an unforgiving solar system to uncover the truth about his missing father and his doomed expedition that now, 30 years later, threatens the universe.",
            "Jo March (Saoirse Ronan) reflects back and forth on her life, telling the beloved story of the March sisters - four young women, each determined to live life on her own terms."
    };

    String[] RUNTIME = {
            "R     | 2h 12min | Comedy, Drama, Thriller",
            "PG-13 | 1h 55min | Action, Adventure, Drama",
            "PG-13 | 1h 37min | Horror, Thriller",
            "PG    | 1h 43min | Animation, Adventure, Comedy ",
            "PG-13 | 3h 1min  | Action, Adventure, Drama",
            "PG-13 | 2h 3min  | Adventure, Drama, Mystery ",
            "PG    | 2h 15min | Drama, Romance",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent dialogIntent = new Intent(getApplicationContext(), DialogActivity.class);
                dialogIntent.putExtra("poster", IMAGES[position]);
                dialogIntent.putExtra("title", TITLES[position]);
                dialogIntent.putExtra("runtime", RUNTIME[position]);
                startActivity(dialogIntent);
            }
        });
    }


    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.custom_layout, null);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
            TextView title = (TextView) convertView.findViewById(R.id.title);
            TextView description = (TextView) convertView.findViewById(R.id.description);

            imageView.setImageResource(IMAGES[position]);
            title.setText(TITLES[position]);
            description.setText(DESCRIPTIONS[position]);

            return convertView;
        }
    }
}