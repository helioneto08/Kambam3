package com.helio.task.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.helio.task.R
import com.helio.task.databinding.FragmentHomeBinding
import com.helio.task.ui.adapter.ViewPagerAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabs()
        initClicks()
    }

    private fun initTabs() {
        val pageAdapter = ViewPagerAdapter(requireActivity())
        pageAdapter.addFragment(TodoFragment(), R.string.status_task_todo)
        pageAdapter.addFragment(DoingFragment(), R.string.status_task_doing)
        pageAdapter.addFragment(DoneFragment(), R.string.status_task_done)

        binding.viewPager.adapter = pageAdapter
        binding.viewPager.offscreenPageLimit = pageAdapter.itemCount

        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = getString(pageAdapter.getTitle(position))
        }.attach()
    }

    private fun initClicks() {
        binding.buttonLogout.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_authentication)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}