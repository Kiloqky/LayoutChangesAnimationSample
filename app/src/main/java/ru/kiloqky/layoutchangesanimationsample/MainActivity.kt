package ru.kiloqky.layoutchangesanimationsample

import android.os.Bundle
import android.transition.*
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.kiloqky.layoutchangesanimationsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Transition.TransitionListener {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = checkNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBtnsFromFirstScene()
        binding.btnBack.setOnClickListener {
            startScene1()
        }
    }

    private fun startScene1() {

        val scene = Scene.getSceneForLayout(
            binding.sceneRoot,
            R.layout.scene_1,
            this
        )

        TransitionManager.go(
            scene
        )

        initBtnsFromFirstScene()
    }

    private fun startScene2() {

        val transitionManager = TransitionManager()

        val scene: Scene = Scene.getSceneForLayout(
            binding.sceneRoot,
            R.layout.scene_2,
            this
        )

        val transition: Transition = TransitionInflater.from(this)
            .inflateTransition(R.transition.scene2_transition)
            .addListener(this)

        transitionManager.setTransition(scene, transition)

        transitionManager.transitionTo(scene)

//        transitionManager.setTransition(
//            scene,
//            Fade()
//        )
//
//        transitionManager.setTransition(
//            scene,
//            Slide()
//        )
//
//        transitionManager.setTransition(
//            scene,
//            Explode()
//        )
//
//        transitionManager.setTransition(
//            scene,
//            AutoTransition()
//        )
//
//        transitionManager.setTransition(
//            scene,
//            ChangeBounds()
//        )
    }

    private fun startScene3() {

        val transitionManager = TransitionInflater.from(this)
            .inflateTransitionManager(
                R.transition.scene3_transition_manager,
                binding.sceneRoot
            )

        val scene = Scene.getSceneForLayout(
            binding.sceneRoot,
            R.layout.scene_3,
            this
        )

        transitionManager.transitionTo(scene)

    }

    private fun startScene4() {
        val transitionManager = TransitionManager()

        val scene: Scene = Scene.getSceneForLayout(
            binding.sceneRoot,
            R.layout.scene_4,
            this
        )

        val transition: Transition = AutoTransition()
            .addListener(this)
            .setDuration(1000)

        transitionManager.setTransition(scene, transition)

        transitionManager.transitionTo(scene)
    }

    private fun startScene5() {
        TransitionManager.beginDelayedTransition(binding.sceneRoot)
        val jerryView: View = binding.sceneRoot.findViewById(R.id.beth_smith)
        val params = jerryView.layoutParams
        val newSize = 240.dp
        params.width = newSize
        params.height = newSize
        jerryView.layoutParams = params
    }

    private fun startScene6() {
        TransitionManager.beginDelayedTransition(binding.sceneRoot)
        val jerryView: View = binding.sceneRoot.findViewById(R.id.jerry_smith)
        val params = jerryView.layoutParams
        val newSize = 240.dp
        params.width = newSize
        params.height = newSize
        jerryView.layoutParams = params
    }

    override fun onTransitionStart(transition: Transition?) {
        Toast.makeText(this, "start", Toast.LENGTH_SHORT).show()
    }

    override fun onTransitionEnd(transition: Transition?) {
        Toast.makeText(this, "end", Toast.LENGTH_SHORT).show()
    }

    override fun onTransitionCancel(transition: Transition?) {
        Toast.makeText(this, "cancel", Toast.LENGTH_SHORT).show()
    }

    override fun onTransitionPause(transition: Transition?) {
        Toast.makeText(this, "pause", Toast.LENGTH_SHORT).show()
    }

    override fun onTransitionResume(transition: Transition?) {
        Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show()
    }

    private fun initBtnsFromFirstScene() {
        binding.sceneRoot.findViewById<View>(R.id.rick_sanchez).setOnClickListener {
            startScene2()
        }
        binding.sceneRoot.findViewById<View>(R.id.morty_smith).setOnClickListener {
            startScene3()
        }
        binding.sceneRoot.findViewById<View>(R.id.summer_smith).setOnClickListener {
            startScene4()
        }
        binding.sceneRoot.findViewById<View>(R.id.beth_smith).setOnClickListener {
            startScene5()
        }
        binding.sceneRoot.findViewById<View>(R.id.jerry_smith).setOnClickListener {
            startScene6()
        }
    }
}