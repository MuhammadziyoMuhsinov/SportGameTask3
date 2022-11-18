package uz.muhammadziyo.sportgametast3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import uz.muhammadziyo.sportgametast3.databinding.ActivityMainBinding
import uz.muhammadziyo.sportgametast3.models.Question

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var list: ArrayList<Question>
    var position = 0
    var ball = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed(object :Runnable{
            override fun run() {
                binding.splash.visibility = View.GONE
                binding.contraint.visibility = View.VISIBLE
            }
        },3000)

        list = ArrayList()
        loadList()

        binding.txtLevel.text = "level ${position+1}"

        binding.txtAnswer1.setOnClickListener {
            if (list[position].correctAnswer == 1) {
                Toast.makeText(binding.root.context, "Javob to'g'ri!", Toast.LENGTH_SHORT).show()

                ball += 50
                binding.txtBall.text = "ball $ball"
                if (position + 1 == list.size) {
                    position = 0
                    loadQuestion()
                } else {
                    position += 1
                    loadQuestion()
                }
                binding.txtLevel.text = "level ${position+1}"
            } else {
                Toast.makeText(binding.root.context, "noto'g'ri!", Toast.LENGTH_SHORT).show()

                if (position + 1 == list.size) {
                    position = 0
                    loadQuestion()
                } else {
                    position += 1
                    loadQuestion()
                }
                binding.txtLevel.text = "level ${position+1}"
            }
        }

        binding.txtAnswer2.setOnClickListener {
            if (list[position].correctAnswer == 2) {
                Toast.makeText(binding.root.context, "Javob to'g'ri!", Toast.LENGTH_SHORT).show()

                ball += 50
                binding.txtBall.text = "ball $ball"
                if (position + 1 == list.size) {
                    position = 0
                } else {
                    position += 1
                    loadQuestion()
                }
                binding.txtLevel.text = "level ${position+1}"
            } else {
                Toast.makeText(binding.root.context, "noto'g'ri!", Toast.LENGTH_SHORT).show()

                if (position + 1 == list.size) {
                    position = 0
                } else {
                    position += 1
                    loadQuestion()
                }
                binding.txtLevel.text = "level ${position+1}"
            }
        }

    }

    fun loadQuestion() {
        binding.txtQuestion.setText(list[position].question)
        binding.txtAnswer1.setText(list[position].answer1)
        binding.txtAnswer2.setText(list[position].answer2)
        binding.imageView.setImageResource(list[position].image)

    }

    fun loadList() {
        list.add(Question("What sport is played\n" +
                " with this ball?", "Lacrosse", "Dodgeball", R.drawable.img_ball, 2))

        list.add(Question("What sport is played with this ball?","TagPro","Tennis",R.drawable.img,2))

        list.add(Question("Gareth Bale’s breakthrough moment came in the 2010-11 season, when he scored a second half hat-trick against which team?","Juventus","Inter Milan",R.drawable.ic_soroq,2))

        list.add(Question("Which swimming style is not allowed in the Olympics?","Freestyle","Dog paddle",R.drawable.ic_soroq,2))

        list.add(Question( "What sport is played with this ball?","Cricket","Baseball",R.drawable.img_2,2))

        list.add(Question("Which of the following is not a water sport?","Paragliding","Rowing",R.drawable.ic_soroq,1))

        list.add(Question("What sport is played with this ball?", "Pool ","Snooker",R.drawable.img_1,1))

        list.add(Question("This iconic kit was the 2018 World Cup kit for which country?","Nigeria","Costa Rica",R.drawable.img_3,1))

    }

}