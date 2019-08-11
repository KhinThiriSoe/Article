package com.khinthirisoe.cararticle.ui.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.khinthirisoe.cararticle.R
import com.khinthirisoe.cararticle.databinding.FragmentOverviewBinding
import com.khinthirisoe.cararticle.domain.ArticleContent
import com.khinthirisoe.cararticle.viewmodels.ArticleViewModel

class OverviewFragment : Fragment() {

    private val viewModel: ArticleViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProviders.of(this, ArticleViewModel.Factory(activity.application))
            .get(ArticleViewModel::class.java)
    }

    private var viewModelAdapter: ArticleAdapter? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.articles.observe(viewLifecycleOwner, Observer<List<ArticleContent>> { article ->
            article?.apply {
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentOverviewBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_overview,
            container,
            false
        )

        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewModel = viewModel

        binding.root.findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = viewModelAdapter
        }

        return binding.root
    }
}
