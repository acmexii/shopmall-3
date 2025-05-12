<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '주문관리' }" />
        <VerticalNavLink
            :item="{
                title: '주문',
                to: '/orders',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '주문항목',
                to: '/orderItems',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '주문 요약 목록',
                to: '/orderSummaries',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '주문 상세 조회',
                to: '/orderDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '주문 품목 목록',
                to: '/orderItemLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '주문 품목 상세',
                to: '/orderItemDetails',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '재고관리' }" />
        <VerticalNavLink
            :item="{
                title: '재고',
                to: '/stocks',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '재고 현황 조회',
                to: '/stockStatusViews',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '재고 변경 이력',
                to: '/stockChangeHistories',
            }"
        />
    </ul>
</template>
