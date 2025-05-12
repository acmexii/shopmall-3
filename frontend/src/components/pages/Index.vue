<template>
  <v-container fluid>
    <v-row>
      <v-card
          v-for="(card, index) in cards"
          :key="index"
          class="mx-auto"
          style="height:300px; width:300px; margin-bottom:20px;"
          outlined
      >
        <v-list-item>
          <v-icon style="margin-top: 30%; margin-left: 37.5%;" color="primary" size="64">mdi-apps</v-icon>
        </v-list-item>
        <v-card-actions>
          <v-btn
              class="mx-auto"
              outlined
              rounded
              :to="card.link"
              style="font-weight:500; font-size:20px; border:solid 2px; max-width:250px; overflow:hidden; margin-top: 10%;"
          >
              {{ card.text }}
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Index',
  data: () => ({
    cards: [
      {
          text: "주문",
          link: "/orders",
      },
      {
          text: "주문항목",
          link: "/orderItems",
      },
      {
          text: "주문 요약 목록",
          link: "/orderSummaries",
      },
      {
          text: "주문 상세 조회",
          link: "/orderDetails",
      },
      {
          text: "주문 품목 목록",
          link: "/orderItemLists",
      },
      {
          text: "주문 품목 상세",
          link: "/orderItemDetails",
      },
      {
          text: "재고",
          link: "/stocks",
      },
      {
          text: "재고 현황 조회",
          link: "/stockStatusViews",
      },
      {
          text: "재고 변경 이력",
          link: "/stockChangeHistories",
      },
    ],
  }),
};
</script>
