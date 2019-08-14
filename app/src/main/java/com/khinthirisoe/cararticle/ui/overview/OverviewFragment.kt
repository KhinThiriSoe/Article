package com.khinthirisoe.cararticle.ui.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.khinthirisoe.cararticle.R
import com.khinthirisoe.cararticle.databinding.FragmentOverviewBinding
import com.khinthirisoe.cararticle.domain.ArticleContent

class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProviders.of(this, OverviewViewModelFactory(activity.application))
            .get(OverviewViewModel::class.java)
    }

    private var viewModelAdapter: OverviewAdapter? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.articleContent.observe(viewLifecycleOwner, Observer<List<ArticleContent>> { content ->
            content?.apply {
                viewModelAdapter?.articleContentLists = content
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
            false)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewModel = viewModel

        viewModelAdapter = OverviewAdapter(ContentClick {
            viewModel.displayContentDetails(it)
        })

        binding.root.findViewById<RecyclerView>(R.id.content_list).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = viewModelAdapter
        }

        viewModel.navigateToSelectedArticle.observe(this, Observer {
            if ( null != it ) {
                this.findNavController().navigate(OverviewFragmentDirections.actionOverviewFragmentToDetailsFragment(it))
                viewModel.displayContentDetailsComplete()
            }
        })

        return binding.root
    }
}
