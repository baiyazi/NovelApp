package com.mengfou.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mengfou.R
import com.mengfou.adapters.HomeFragmentPagerAdapter
import com.mengfou.databinding.FragmentHomeBinding
import com.mengfou.viewmodels.HomeFragmentViewModel

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
    private lateinit var homeFragmentViewModel: HomeFragmentViewModel
    private lateinit var homePagerAdapter: HomeFragmentPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if(binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
            homeFragmentViewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            ).get(HomeFragmentViewModel::class.java)
            lifecycle.addObserver(homeFragmentViewModel)
            homeFragmentViewModel.tabLiveData.observe(viewLifecycleOwner, tabDataObserver)
        }
        return binding!!.root
    }

    private var tabDataObserver = object : Observer<List<HomeFragmentViewModel.NovelType>> {
        override fun onChanged(tabs: List<HomeFragmentViewModel.NovelType>?) {
            tabs?.apply {
                homePagerAdapter.datas.clear()
                for (item in this) {
                    homePagerAdapter.datas.add(item)
                }
                homePagerAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(binding!!.viewpager.adapter == null){
            binding!!.tabLayout.setupWithViewPager(binding!!.viewpager)
            homePagerAdapter = HomeFragmentPagerAdapter(resources, requireActivity().supportFragmentManager)
            binding!!.viewpager.adapter = homePagerAdapter
        }
    }

    override fun onDestroy() {
        homeFragmentViewModel.tabLiveData.removeObserver(tabDataObserver)
        lifecycle.removeObserver(homeFragmentViewModel)
        binding = null
        super.onDestroy()
    }
}