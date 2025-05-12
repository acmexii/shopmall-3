import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/orders',
      component: () => import('../components/ui/OrderGrid.vue'),
    },
    {
      path: '/orderItems',
      component: () => import('../components/ui/OrderItemGrid.vue'),
    },
    {
      path: '/stocks',
      component: () => import('../components/ui/StockGrid.vue'),
    },
  ],
})

export default router;
